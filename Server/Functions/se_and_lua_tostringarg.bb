Function se_and_lua_tostringarg$(arg0%)
    If (currentluastate <> $00) Then
        Return slua_to_string(currentluastate, (arg0 + $01))
    Else
        Return se_tostringarg(arg0, "")
    EndIf
    Return ""
End Function
