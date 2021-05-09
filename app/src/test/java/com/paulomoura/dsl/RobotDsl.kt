package com.paulomoura.dsl

fun <T : BaseRobot> initRobot(robot: T, function: T.() -> Unit): T {
    with(robot, function)
    return robot
}

infix fun <T : BaseRobot> T.then(function: T.() -> Unit) : T = this.apply(function)
infix fun <T : BaseRobot> T.andVerifyThat(function: T.() -> Unit) : T = this.apply(function)

open class BaseRobot