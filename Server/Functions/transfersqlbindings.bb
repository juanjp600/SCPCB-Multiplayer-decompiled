Function transfersqlbindings%(arg0%, arg1%)
    Local local0%
    Local local1%
    If (arg0 = $00) Then
        arg0 = currentstatementhandle
    EndIf
    If (((arg0 <> $00) And (arg1 <> $00)) <> 0) Then
        local0 = sqlite3_transfer_bindings(arg0, arg1)
        If (local0 = $00) Then
            Return $01
        Else
            Return sqlite3_errorhasoccurred("TransferBindings", local1, "")
        EndIf
    Else
        Return $00
    EndIf
    Return $00
End Function
