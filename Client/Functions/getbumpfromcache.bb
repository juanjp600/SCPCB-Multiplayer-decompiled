Function getbumpfromcache%(arg0$)
    Local local0.materials
    For local0 = Each materials
        If (local0\Field0 = arg0) Then
            Return local0\Field2
        EndIf
    Next
    Return $00
    Return $00
End Function
