Function multiplayer_breach_setroleanimation%(arg0%, arg1%, arg2%, arg3%, arg4#)
    Local local0.breachtypes
    local0 = getbreachtype(arg0)
    local0\Field16[arg1] = packtwovalues(arg2, arg3)
    local0\Field17[arg1] = arg4
    Return $00
End Function
