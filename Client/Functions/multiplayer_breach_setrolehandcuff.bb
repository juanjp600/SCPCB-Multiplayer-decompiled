Function multiplayer_breach_setrolehandcuff%(arg0%, arg1$, arg2#, arg3#, arg4#, arg5$, arg6#, arg7#, arg8#)
    Local local0.breachtypes
    local0 = getbreachtype(arg0)
    local0\Field29 = ((arg1 <> "") Or (arg5 <> ""))
    local0\Field30[$00] = arg1
    local0\Field30[$01] = (Str arg2)
    local0\Field30[$02] = (Str arg3)
    local0\Field30[$03] = (Str arg4)
    local0\Field30[$04] = arg5
    local0\Field30[$05] = (Str arg6)
    local0\Field30[$06] = (Str arg7)
    local0\Field30[$07] = (Str arg8)
    Return $00
End Function
