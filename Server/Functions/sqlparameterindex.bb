Function sqlparameterindex%(arg0$, arg1%)
    If (arg1 = $00) Then
        arg1 = currentstatementhandle
    EndIf
    If (arg1 <> $00) Then
        Return sqlite3_bind_parameter_index(arg1, arg0)
    Else
        Return $00
    EndIf
    Return $00
End Function
