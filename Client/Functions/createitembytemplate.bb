Function createitembytemplate.items(arg0.itemtemplates, arg1#, arg2#, arg3#, arg4%, arg5%, arg6%, arg7#, arg8%, arg9%)
    Local local0.items
    Local local1.itemtemplates
    Local local2$
    Local local3$
    Local local4%
    If (arg0 = Null) Then
        Return Null
    EndIf
    local0 = (New items)
    local1 = arg0
    local2 = ""
    local3 = ""
    local0\Field3 = local1
    local0\Field1 = createpivot($00)
    entityradius(local0\Field1, 0.01, 0.0)
    entitypickmode(local0\Field1, $00, $00)
    local0\Field2 = copyentity(local1\Field5, local0\Field1)
    local0\Field0 = local1\Field1
    local2 = local1\Field1
    local3 = local1\Field2
    showentity(local0\Field1)
    showentity(local0\Field2)
    resetentity(local0\Field1)
    positionentity(local0\Field1, arg1, arg2, arg3, $01)
    rotateentity(local0\Field1, 0.0, (Float itemsrotaterand), 0.0, $00)
    local0\Field11 = entitydistance(collider, local0\Field1)
    local0\Field30 = $00
    local0\Field28 = -41189.0
    local0\Field4 = 0.0
    If (local3 = "cup") Then
        local0\Field5 = arg4
        local0\Field6 = arg5
        local0\Field7 = arg6
        local0\Field8 = arg7
        local4 = copyentity(liquidobj, $00)
        scaleentity(local4, local0\Field3\Field14, local0\Field3\Field14, local0\Field3\Field14, $01)
        positionentity(local4, entityx(local0\Field1, $01), entityy(local0\Field1, $01), entityz(local0\Field1, $01), $00)
        entityparent(local4, local0\Field2, $01)
        entitycolor(local4, (Float arg4), (Float arg5), (Float arg6))
        If (0.0 > arg7) Then
            entityfx(local4, $01)
            entityalpha(local4, (Abs arg7))
        Else
            entityalpha(local4, (Abs arg7))
        EndIf
        entityshininess(local4, 1.0)
    EndIf
    local0\Field16 = local0\Field3\Field8
    If (((local3 = "clipboard") And (arg8 = $00)) <> 0) Then
        arg8 = $0A
        setanimtime(local0\Field2, 17.0, $00)
        local0\Field16 = local0\Field3\Field9
    ElseIf (((local3 = "wallet") And (arg8 = $00)) <> 0) Then
        arg8 = $0A
        setanimtime(local0\Field2, 0.0, $00)
    EndIf
    entitytype(local0\Field1, $03, $00)
    local0\Field19 = arg8
    Return local0
    Return Null
End Function
