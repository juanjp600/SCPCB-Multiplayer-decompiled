Function rd_update%(arg0.rd_bone)
    Local local0#
    Local local1#
    Local local2#
    vector_update(arg0\Field1, entityx(arg0\Field0, $00), entityy(arg0\Field0, $00), entityz(arg0\Field0, $00))
    local0 = (((- (arg0\Field1\Field0 - arg0\Field3)) * 0.08) * fpsfactor)
    local1 = (((- (arg0\Field1\Field1 - arg0\Field4)) * 0.08) * fpsfactor)
    local2 = (((- (arg0\Field1\Field2 - arg0\Field5)) * 0.08) * fpsfactor)
    moveentity(arg0\Field0, local0, local1, local2)
    If ((((1.0 < local0) Or (1.0 < local1)) Or (1.0 < local2)) <> 0) Then
        positionentity(arg0\Field0, arg0\Field3, arg0\Field4, arg0\Field5, $00)
    EndIf
    Return $00
End Function
