Function executesql%(arg0$, arg1%, arg2%)
    Local local0%
    If (arg1 = $00) Then
        arg1 = currentdatabasehandle
    EndIf
    If (arg1 <> $00) Then
        local0 = sqlite3_exec(arg1, arg0, $00, $00, $00)
        If (local0 = $00) Then
            Return $01
        Else
            Return sqlite3_errorhasoccurred("ExecuteSQL", arg2, "")
        EndIf
    Else
        Return $00
    EndIf
    Return $00
End Function
