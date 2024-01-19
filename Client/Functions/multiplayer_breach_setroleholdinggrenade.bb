Function multiplayer_breach_setroleholdinggrenade%(arg0%, arg1$, arg2#, arg3#)
    Local local0.breachtypes
    local0 = getbreachtype(arg0)
    local0\Field25 = (0.0 <> (arg2 + arg3))
    local0\Field26[$00] = arg1
    local0\Field26[$01] = (Str arg2)
    local0\Field26[$02] = (Str arg3)
    Return $00
End Function
