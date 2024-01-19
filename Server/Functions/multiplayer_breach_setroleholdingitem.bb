Function multiplayer_breach_setroleholdingitem%(arg0%, arg1#, arg2#)
    Local local0.breachtypes
    local0 = getbreachtype(arg0)
    local0\Field25 = (0.0 <> (arg1 + arg2))
    local0\Field26[$00] = arg1
    local0\Field26[$01] = arg2
    Return $00
End Function
