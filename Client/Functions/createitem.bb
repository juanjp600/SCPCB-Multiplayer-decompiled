Function createitem.items(arg0$, arg1$, arg2#, arg3#, arg4#, arg5%, arg6%, arg7%, arg8#, arg9%, arg10%)
    Local local0.items
    Local local1.itemtemplates
    Local local2%
    local0 = (New items)
    arg0 = lower(arg0)
    arg1 = lower(arg1)
    For local1 = Each itemtemplates
        If (lower(local1\Field1) = arg0) Then
            If (lower(local1\Field2) = arg1) Then
                local0\Field3 = local1
                local0\Field1 = createpivot($00)
                entityradius(local0\Field1, 0.01, 0.0)
                entitypickmode(local0\Field1, $00, $00)
                local0\Field2 = copyentity(local1\Field5, local0\Field1)
                local0\Field0 = local1\Field1
                showentity(local0\Field1)
                showentity(local0\Field2)
                Exit
            EndIf
        EndIf
    Next
    If (local0\Field3 = Null) Then
        Delete local0
        Return Null
    EndIf
    resetentity(local0\Field1)
    positionentity(local0\Field1, arg2, arg3, arg4, $01)
    rotateentity(local0\Field1, 0.0, (Float itemsrotaterand), 0.0, $00)
    entitytype(local0\Field1, $03, $00)
    local0\Field11 = entitydistance(collider, local0\Field1)
    local0\Field30 = $00
    local0\Field28 = -41189.0
    local0\Field4 = 0.0
    If (arg1 = "cup") Then
        local0\Field5 = arg5
        local0\Field6 = arg6
        local0\Field7 = arg7
        local0\Field8 = arg8
        local2 = copyentity(liquidobj, $00)
        scaleentity(local2, local0\Field3\Field14, local0\Field3\Field14, local0\Field3\Field14, $01)
        positionentity(local2, entityx(local0\Field1, $01), entityy(local0\Field1, $01), entityz(local0\Field1, $01), $00)
        entityparent(local2, local0\Field2, $01)
        entitycolor(local2, (Float arg5), (Float arg6), (Float arg7))
        If (0.0 > arg8) Then
            entityfx(local2, $01)
            entityalpha(local2, (Abs arg8))
        Else
            entityalpha(local2, (Abs arg8))
        EndIf
        entityshininess(local2, 1.0)
    EndIf
    local0\Field16 = local0\Field3\Field8
    If (((arg1 = "clipboard") And (arg9 = $00)) <> 0) Then
        arg9 = $0A
        setanimtime(local0\Field2, 17.0, $00)
        local0\Field16 = local0\Field3\Field9
    ElseIf (((arg1 = "wallet") And (arg9 = $00)) <> 0) Then
        arg9 = $0A
        setanimtime(local0\Field2, 0.0, $00)
    EndIf
    local0\Field19 = arg9
    setitemid(local0, findfreeitemid())
    local0\Field22 = $00
    Return local0
    Return Null
End Function
