Function rd_addentity.rd_bone(arg0%, arg1%)
    Local local0.rd_bone
    local0 = (New rd_bone)
    local0\Field0 = arg0
    local0\Field2 = arg1
    local0\Field1 = vector_create()
    local0\Field3 = entityx(arg1, $00)
    local0\Field4 = entityy(arg1, $00)
    local0\Field5 = entityz(arg1, $00)
    vector_update(local0\Field1, entityx(arg0, $00), entityy(arg0, $00), entityz(arg0, $00))
    Return local0
    Return Null
End Function
