Function mp_getserverfromcategory.mp_listserver(arg0$, arg1%, arg2%)
    Local local0.mp_listserver
    For local0 = Each mp_listserver
        If ((((local0\Field10 = arg2) And (local0\Field1 = arg1)) And (local0\Field0 = arg0)) <> 0) Then
            Return local0
        EndIf
    Next
    Return Null
    Return Null
End Function
