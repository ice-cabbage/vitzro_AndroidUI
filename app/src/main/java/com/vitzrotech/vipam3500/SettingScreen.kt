package com.vitzrotech.vipam3500

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vitzrotech.vipam3500.ui.theme.VIPAM3500Theme
import org.eclipse.paho.client.mqttv3.IMqttActionListener
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.IMqttToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage
import java.nio.ByteBuffer

var mqttClient: MQTTClient? = null

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SettingScreen(viewModel: SharedViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        var serverUri by rememberSaveable { mutableStateOf("tcp://10.0.2.2:1883") }
        var clientId by rememberSaveable { mutableStateOf("") }
        var username by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var pubTopic by rememberSaveable { mutableStateOf("") }
        var pubMessage by rememberSaveable { mutableStateOf("") }
        var subTopic by rememberSaveable { mutableStateOf("") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        val context = LocalContext.current
        var connected by rememberSaveable { mutableStateOf(mqttClient?.isConnected() ?: false) }
        val keyboardController = LocalSoftwareKeyboardController.current

        if (!connected) {
            TextField(
                value = serverUri,
                onValueChange = {value ->
                    serverUri = value
                },
                label = { Text(text = stringResource(id = R.string.server_uri)) },
                placeholder = { Text(text = stringResource(id = R.string.type_server_uri)) },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = clientId,
                onValueChange = {value ->
                    clientId = value
                },
                label = { Text(text = stringResource(id = R.string.client_id)) },
                placeholder = { Text(text = stringResource(id = R.string.type_client_id)) },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = username,
                onValueChange = {value ->
                    username = value
                },
                label = { Text(text = stringResource(id = R.string.username)) },
                placeholder = { Text(text = stringResource(id = R.string.type_username)) },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = password,
                onValueChange = {value ->
                    password = value
                },
                label = { Text(text = stringResource(id = R.string.password)) },
                placeholder = { Text(text = stringResource(id = R.string.type_password)) },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        if (passwordVisible)
                            Icon(painterResource(R.drawable.ic_visibility), "Visibility")
                        else
                            Icon(
                                painterResource(R.drawable.ic_visibility_off),
                                "Visibility off"
                            )
                    }
                }
            )
            ElevatedButton(
                onClick = {
                    Log.d("", "$serverUri, $clientId, $username, $password")
                    mqttClient = MQTTClient(context, serverUri, clientId)
                    mqttClient?.connect(username, password,
                        object : IMqttActionListener {
                            override fun onSuccess(asyncActionToken: IMqttToken?) {
                                Log.d(this.javaClass.name, "Connection success")
                                connected = true
                            }

                            override fun onFailure(
                                asyncActionToken: IMqttToken?,
                                exception: Throwable?
                            ) {
                                Log.d(
                                    this.javaClass.name,
                                    "Connection failure: ${exception.toString()}"
                                )
                            }
                        },
                        object : MqttCallback {
                            override fun messageArrived(topic: String?, message: MqttMessage?) {
                                if (topic != null) {
                                    if (message != null) {
                                        val str = message.toString()
                                        Log.d("topic", topic)
                                        if (topic == "sampled_value") {
                                            viewModel.messageArrived(topic, message.payload.toIntArray())
                                        }else if (str.matches(Regex("^[\\p{Nd}]+$")))  {
                                            viewModel.messageArrived(topic, str.toInt())
                                        } else if (str.matches(Regex("^[\\p{Nd}]+[.][\\p{Nd}Ee]+$"))) {
                                            viewModel.messageArrived(topic, str.toFloat())
                                        } else if (str.startsWith("0x")) {
                                            viewModel.messageArrived(topic, str.drop(2).toUInt(16))
                                        } else {
                                            viewModel.messageArrived(topic, str)
                                        }
                                    }
                                }
                            }

                            override fun connectionLost(cause: Throwable?) {
                                mqttClient?.defaultCbClient?.connectionLost(cause)
                                Log.d(
                                    this.javaClass.name,
                                    "Connection lost ${cause.toString()}"
                                )
                                connected = false
                            }
                            override fun deliveryComplete(token: IMqttDeliveryToken?) {
                                mqttClient?.defaultCbClient?.deliveryComplete(token)
                                Log.d(this.javaClass.name, "Delivery complete")
                            }
                        }
                    )
                    keyboardController?.hide()
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(stringResource(R.string.connect))
            }
        } else {
            TextField(
                value = pubTopic,
                onValueChange = {value ->
                    pubTopic = value
                },
                label = { Text(text = stringResource(id = R.string.topic)) },
                placeholder = { Text(text = stringResource(id = R.string.type_topic)) },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = pubMessage,
                onValueChange = {value ->
                    pubMessage = value
                },
                label = { Text(text = stringResource(id = R.string.message)) },
                placeholder = { Text(text = stringResource(id = R.string.type_message)) },
                modifier = Modifier.fillMaxWidth()
            )
            ElevatedButton(
                onClick = {
                    if (mqttClient?.isConnected() == true) {
                        mqttClient?.publish(pubTopic, pubMessage, 1, false,
                            object : IMqttActionListener {
                                override fun onSuccess(asyncActionToken: IMqttToken?) {
                                    val msg ="Publish message: $pubMessage to topic: $pubTopic"
                                    Log.d(this.javaClass.name, msg)
                                }

                                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                                    Log.d(this.javaClass.name, "Failed to publish message to topic")
                                }
                            })
                    } else {
                        Log.d(this.javaClass.name, "Impossible to publish, no server connected")
                        connected = false
                    }
                    keyboardController?.hide()
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(stringResource(R.string.publish))
            }
            TextField(
                value = subTopic,
                onValueChange = {value ->
                    subTopic = value
                },
                label = { Text(text = stringResource(id = R.string.topic)) },
                placeholder = { Text(text = stringResource(id = R.string.type_topic)) },
                modifier = Modifier.fillMaxWidth()
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                ElevatedButton(
                    onClick = {
                        if (mqttClient?.isConnected() == true) {
                            mqttClient?.subscribe(subTopic, 1,
                                object : IMqttActionListener {
                                    override fun onSuccess(asyncActionToken: IMqttToken?) {
                                        val msg = "Subscribed to: $subTopic"
                                        Log.d(this.javaClass.name, msg)
                                    }

                                    override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                                        Log.d(this.javaClass.name, "Failed to subscribe: $subTopic")
                                    }
                                })
                        } else {
                            Log.d(this.javaClass.name, "Impossible to subscribe, no server connected")
                            connected = false
                        }
                        keyboardController?.hide()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(R.string.subscribe))
                }
                ElevatedButton(
                    onClick = {
                        if (mqttClient?.isConnected() == true) {
                            mqttClient?.unsubscribe( subTopic,
                                object : IMqttActionListener {
                                    override fun onSuccess(asyncActionToken: IMqttToken?) {
                                        val msg = "Unsubscribed to: $subTopic"
                                        Log.d(this.javaClass.name, msg)
                                    }

                                    override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                                        Log.d(this.javaClass.name, "Failed to unsubscribe: $subTopic")
                                    }
                                })
                        } else {
                            Log.d(this.javaClass.name, "Impossible to unsubscribe, no server connected")
                            connected = false
                        }
                        keyboardController?.hide()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(stringResource(R.string.unsubscribe))
                }
            }
            ElevatedButton(
                onClick = {
                    if (mqttClient?.isConnected() == true) {
                        // Disconnect from MQTT Broker
                        mqttClient?.disconnect(object : IMqttActionListener {
                            override fun onSuccess(asyncActionToken: IMqttToken?) {
                                Log.d(this.javaClass.name, "Disconnected")
                                connected = false
                            }

                            override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
                                Log.d(this.javaClass.name, "Failed to disconnect")
                            }
                        })
                    } else {
                        Log.d(this.javaClass.name, "Impossible to disconnect, no server connected")
                        connected = false;
                    }
                    keyboardController?.hide()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.disconnect))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MQTTScreenPreview() {
    VIPAM3500Theme {
        SettingScreen(viewModel())
    }
}

fun Float.toByteArray(): ByteArray {
    return ByteBuffer.allocate(4).putFloat(this).array()
}

fun UInt.toByteArray(): ByteArray {
    return ByteBuffer.allocate(4).putInt(this.toInt()).array()
}

fun ByteArray.toFloat(): Float {
    return ByteBuffer.wrap(this).float
}

fun ByteArray.toUInt(): UInt {
    return ByteBuffer.wrap(this).int.toUInt()
}

fun IntArray.toByteArray(): ByteArray {
    val bytes = ByteBuffer.allocate(this.size * Int.SIZE_BYTES)
    bytes.asIntBuffer().put(this)
    return bytes.array()
}

fun  ByteArray.toIntArray(): IntArray {
    val ints = IntArray(this.size / Int.SIZE_BYTES)
    ByteBuffer.wrap(this).asIntBuffer()[ints]
    return ints
}
