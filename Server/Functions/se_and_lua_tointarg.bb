Function se_and_lua_tointarg%(arg0%)
    If (currentluastate <> $00) Then
        Return slua_to_integer(currentluastate, (arg0 + $01))
    Else
        Return se_tointarg(arg0, $00)
    EndIf
    Return $00
End Function
