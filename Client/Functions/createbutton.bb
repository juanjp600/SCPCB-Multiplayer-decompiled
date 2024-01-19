Function createbutton%(arg0#, arg1#, arg2#, arg3#, arg4#, arg5#)
    Local local0%
    local0 = copyentity(buttonobj, $00)
    scaleentity(local0, 0.03, 0.03, 0.03, $00)
    positionentity(local0, arg0, arg1, arg2, $00)
    rotateentity(local0, arg3, arg4, arg5, $00)
    Return local0
    Return $00
End Function
