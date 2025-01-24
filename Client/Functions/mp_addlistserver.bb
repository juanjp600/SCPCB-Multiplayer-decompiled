Function mp_addlistserver.mp_listserver(arg0$, arg1%, arg2%)
    Local local0%
    Local local1$
    Local local2.mp_listserver
    local0 = mp_getserveraddress(arg0)
    If (local0 = $00) Then
        Return Null
    EndIf
    local1 = dottedip(local0)
    For local2 = Each mp_listserver
        If ((((local2\Field10 = arg2) And (local2\Field1 = arg1)) And (local2\Field0 = local1)) <> 0) Then
            Return Null
        EndIf
    Next
    local2 = (New mp_listserver)
    local2\Field0 = local1
    local2\Field1 = arg1
    local2\Field2 = ((local1 + ":") + (Str arg1))
    local2\Field3 = "-"
    local2\Field8 = "-"
    local2\Field4 = $00
    local2\Field5 = $00
    local2\Field6 = $00
    local2\Field10 = arg2
    If (mp_pingserver(local2\Field0, local2\Field1, $00, $00) = $00) Then
        mp_removelistserver(local2)
    EndIf
    Return local2
    Return Null
End Function
