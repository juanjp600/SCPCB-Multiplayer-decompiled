Function move_forward%(arg0%, arg1%, arg2%, arg3%)
    If (arg0 = $01) Then
        If (arg3 = $00) Then
            Return arg1
        Else
            Return (arg2 + $01)
        EndIf
    EndIf
    If (arg3 = $00) Then
        Return ((arg1 - $01) + arg0)
    Else
        Return arg2
    EndIf
    Return $00
End Function
