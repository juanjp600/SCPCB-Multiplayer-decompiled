Function getserverinlist.servers(arg0$, arg1%, arg2%)
    Local local0.servers
    For local0 = Each servers
        If ((((local0\Field1 = arg0) And (local0\Field2 = (Str arg1))) And (arg2 = local0\Field0)) <> 0) Then
            Return local0
        EndIf
    Next
    Return Null
End Function
