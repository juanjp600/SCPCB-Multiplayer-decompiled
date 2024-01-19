Function multiplayer_breach_setrolehandcuff%(arg0%, arg1$, arg2#, arg3#, arg4#, arg5$, arg6#, arg7#, arg8#)
    Local local0.breachtypes
    local0 = getbreachtype(arg0)
    local0\Field27 = ((arg1 <> "") Or (arg5 <> ""))
    local0\Field28[$00] = arg1
    local0\Field28[$01] = (Str arg2)
    local0\Field28[$02] = (Str arg3)
    local0\Field28[$03] = (Str arg4)
    local0\Field28[$04] = arg5
    local0\Field28[$05] = (Str arg6)
    local0\Field28[$06] = (Str arg7)
    local0\Field28[$07] = (Str arg8)
    Return $00
End Function
