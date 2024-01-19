Function committransaction%(arg0%, arg1%, arg2%)
    If (arg1 = $00) Then
        arg1 = currentdatabasehandle
    EndIf
    If (arg1 <> $00) Then
        If (arg0 <> 0) Then
            executesql("COMMIT", arg1, arg2)
            Return (executesql("BEGIN", arg1, arg2) = $00)
        Else
            Return (executesql("COMMIT", arg1, arg2) = $00)
        EndIf
    Else
        Return $00
    EndIf
    Return $00
End Function
