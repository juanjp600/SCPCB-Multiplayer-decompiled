Function copyattachmodelpreset%(arg0%, arg1%, arg2%)
    Local local0.mp_attachmodelpreset
    Local local1.mp_attachmodelpreset
    local0 = createattachmodelpreset(arg0, arg1)
    local1 = createattachmodelpreset(arg2, arg1)
    local1\Field0 = local0\Field0
    local1\Field1 = local0\Field1
    local1\Field2 = local0\Field2
    local1\Field3 = local0\Field3
    local1\Field4 = local0\Field4
    local1\Field5 = local0\Field5
    local1\Field6 = local0\Field6
    local1\Field7 = local0\Field7
    Return $00
End Function
