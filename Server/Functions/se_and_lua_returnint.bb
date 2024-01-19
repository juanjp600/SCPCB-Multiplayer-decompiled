Function se_and_lua_returnint%(arg0%)
    If (currentluastate <> $00) Then
        slua_push_integer(currentluastate, arg0)
    Else
        se_returnint(arg0)
    EndIf
    Return $00
End Function
