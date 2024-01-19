Function getcache.materials(arg0$)
    Local local0.materials
    For local0 = Each materials
        If (local0\Field0 = arg0) Then
            Return local0
        EndIf
    Next
    Return Null
    Return Null
End Function
