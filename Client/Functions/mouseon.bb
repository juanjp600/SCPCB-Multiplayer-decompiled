Function mouseon%(arg0%, arg1%, arg2%, arg3%)
    If (((scaledmousex() > arg0) And (scaledmousex() < (arg0 + arg2))) <> 0) Then
        If (((scaledmousey() > arg1) And (scaledmousey() < (arg1 + arg3))) <> 0) Then
            Return $01
        EndIf
    EndIf
    Return $00
    Return $00
End Function
