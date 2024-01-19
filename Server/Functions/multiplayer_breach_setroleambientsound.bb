Function multiplayer_breach_setroleambientsound%(arg0%, arg1%, arg2$)
    Local local0.breachtypes
    local0 = getbreachtype(arg0)
    local0\Field16[arg1] = arg2
    Return $00
End Function
