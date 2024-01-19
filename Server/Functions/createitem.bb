Function createitem.items(arg0$, arg1$, arg2#, arg3#, arg4#, arg5%, arg6%, arg7%, arg8#, arg9%, arg10%)
    Local local0.items
    Local local1.itemtemplates
    local0 = (New items)
    arg0 = lower(arg0)
    arg1 = lower(arg1)
    For local1 = Each itemtemplates
        If (lower(local1\Field1) = arg0) Then
            If (lower(local1\Field2) = arg1) Then
                local0\Field3 = local1
                local0\Field0 = local1\Field1
                Exit
            EndIf
        EndIf
    Next
    If (local0\Field3 = Null) Then
        Delete local0
        Return Null
    EndIf
    local0\Field1 = createpivot($00)
    positionentity(local0\Field1, arg2, arg3, arg4, $01)
    rotateentity(local0\Field1, 0.0, (Float itemsrotaterand), 0.0, $00)
    entityradius(local0\Field1, 0.01, 0.0)
    entitypickmode(local0\Field1, $00, $00)
    local0\Field11 = entitydistance(collider, local0\Field1)
    local0\Field4 = 0.0
    local0\Field29 = -14934890.0
    local0\Field19 = arg9
    setitemid(local0, findfreeitemid())
    local0\Field22 = $00
    If (getscripts() <> 0) Then
        public_inqueue($36, $00)
        public_addparam($00, (Str local0\Field18), $01)
        callback($00)
    EndIf
    entitytype(local0\Field1, $03, $00)
    Return local0
    Return Null
End Function
