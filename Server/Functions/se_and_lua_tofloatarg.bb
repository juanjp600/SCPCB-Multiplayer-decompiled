Function se_and_lua_tofloatarg#(arg0%)
    If (currentluastate <> $00) Then
        Return slua_to_number(currentluastate, (arg0 + $01))
    Else
        Return se_tofloatarg(arg0, 0.0)
    EndIf
    Return 0.0
End Function
