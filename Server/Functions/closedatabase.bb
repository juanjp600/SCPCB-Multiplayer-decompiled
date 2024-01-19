Function closedatabase%(arg0%, arg1%)
    Local local0%
    If (arg0 = $00) Then
        arg0 = currentdatabasehandle
    EndIf
    If (arg0 <> $00) Then
        local0 = sqlite3_close(arg0)
        If (local0 = $00) Then
            If (arg0 = currentdatabasehandle) Then
                currentdatabasehandle = $00
            EndIf
            Return $01
        Else
            sqlite3_errorhasoccurred("CloseDatabase", arg1, "")
        EndIf
    Else
        Return $00
    EndIf
    Return $00
End Function
