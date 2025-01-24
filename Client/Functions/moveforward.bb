Function moveforward%(arg0%, arg1%, arg2%, arg3%)
    If (arg0 = $01) Then
        If (arg3 <> 0) Then
            Return (arg2 + $01)
        Else
            Return arg1
        EndIf
    EndIf
    If (arg3 <> 0) Then
        Return arg2
    Else
        Return ((arg1 - $01) + arg0)
    EndIf
    Return $00
End Function
