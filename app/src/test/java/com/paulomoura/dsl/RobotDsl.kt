package com.paulomoura.dsl

fun <T : BaseRobot> initRobot(robotClass: Class<T>, function: T.() -> Unit): T {
    val robot = robotClass.newInstance()
    with(robot, function)
    return robot
}

infix fun <T : BaseRobot> T.then(function: T.() -> Unit) : T = this.apply(function)
infix fun <T : BaseRobot> T.andVerifyThat(function: T.() -> Unit) : T = this.apply(function)

open class BaseRobot