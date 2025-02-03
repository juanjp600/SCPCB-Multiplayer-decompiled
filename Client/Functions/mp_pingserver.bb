Function mp_pingserver%(arg0$, arg1%, arg2%, arg3%)
    Local local0.mp_serverping
    Local local1%
    Local local2.mp_serverping
    local1 = mp_getserveraddress(arg0)
    If (local1 = $00) Then
        Return $00
    EndIf
    For local2 = Each mp_serverping
        If (((local2\Field0 = local1) And (local2\Field1 = arg1)) <> 0) Then
            local0 = local2
            Exit
        EndIf
    Next
    If (local0 = Null) Then
        local0 = (New mp_serverping)
        local0\Field0 = local1
        local0\Field1 = arg1
        local0\Field2 = createnetworkbuffer($200)
    EndIf
    local0\Field3 = $00
    local0\Field4 = arg2
    local0\Field6 = millisecs()
    If (local0\Field5 = $00) Then
        local0\Field5 = millisecs()
    EndIf
    mp_ping\Field3 = local1
    mp_ping\Field4 = arg1
    writebyte(mp_ping\Field0, $03)
    writebyte(mp_ping\Field0, arg3)
    sendudpmsg(mp_ping\Field0, local1, arg1)
    Return $01
    Return $00
End Function
