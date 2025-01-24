Function findspritefont.spritefont(arg0$)
    Local local0.spritefont
    For local0 = Each spritefont
        If (local0\Field0 = arg0) Then
            Return local0
        EndIf
    Next
    Return Null
    Return Null
End Function
