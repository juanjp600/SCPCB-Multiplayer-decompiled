Function setdatabasetimeout%(arg0%, arg1%, arg2%)
    Local local0%
    If (arg1 = $00) Then
        arg1 = currentdatabasehandle
    EndIf
    If (arg1 <> $00) Then
        local0 = sqlite3_busy_timeout(arg1, arg0)
        If (local0 = $00) Then
            Return $01
        Else
            sqlite3_errorhasoccurred("SetDatabaseTimeout", arg2, "")
        EndIf
    Else
        Return $00
    EndIf
    Return $00
End Function
