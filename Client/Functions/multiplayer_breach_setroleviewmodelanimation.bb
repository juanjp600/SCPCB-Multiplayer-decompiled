Function multiplayer_breach_setroleviewmodelanimation%(arg0%, arg1%, arg2%, arg3%, arg4#)
    Local local0.breachtypes
    local0 = getbreachtype(arg0)
    local0\Field21[arg1] = packtwovalues(arg2, arg3)
    local0\Field22[arg1] = arg4
    Return $00
End Function
