Function changermesh%(arg0.rooms, arg1$)
    Local local0%[200]
    Local local1%
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6%
    For local1 = $01 To countchildren(arg0\Field2) Step $01
        local0[local1] = getchild(arg0\Field2, local1)
        entityparent(local0[local1], $00, $01)
    Next
    arg0\Field7\Field0 = loadrmesh(arg1, arg0\Field7)
    local2 = entityx(arg0\Field2, $00)
    local3 = entityy(arg0\Field2, $00)
    local4 = entityz(arg0\Field2, $00)
    local5 = entityyaw(arg0\Field2, $00)
    hideentity(arg0\Field2)
    entitytype(arg0\Field2, $00, $00)
    entitypickmode(arg0\Field2, $00, $01)
    resetentity(arg0\Field2)
    local6 = arg0\Field2
    arg0\Field2 = copyentity(arg0\Field7\Field0, $00)
    scaleentity(arg0\Field2, roomscale, roomscale, roomscale, $00)
    entitytype(arg0\Field2, $01, $00)
    entitypickmode(arg0\Field2, $02, $01)
    positionentity(arg0\Field2, local2, local3, local4, $00)
    rotateentity(arg0\Field2, 0.0, local5, 0.0, $00)
    For local1 = $01 To $C7 Step $01
        If (local0[local1] <> $00) Then
            entityparent(local0[local1], arg0\Field2, $01)
        EndIf
    Next
    freeentity(arg0\Field2)
    Return $00
End Function
