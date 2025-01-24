Function createitem.items(arg0$, arg1%, arg2#, arg3#, arg4#, arg5%, arg6%, arg7%, arg8#, arg9%)
    Local local0.items
    Local local1.itemtemplates
    Local local3%
    catcherrors((((((((((((((((((((("CreateItem.Items(" + arg0) + ", ") + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)) + ", ") + (Str arg4)) + ", ") + (Str arg5)) + ", ") + (Str arg6)) + ", ") + (Str arg7)) + ", ") + (Str arg8)) + ", ") + (Str arg9)) + ")"))
    arg0 = lower(arg0)
    local0 = (New items)
    For local1 = Each itemtemplates
        If (((lower(local1\Field1) = arg0) And (local1\Field2 = arg1)) <> 0) Then
            local0\Field4 = local1
            local0\Field2 = createpivot($00)
            entityradius(local0\Field2, 0.01, 0.0)
            entitypickmode(local0\Field2, $01, $00)
            local0\Field3 = copyentity(local1\Field5, local0\Field2)
            local0\Field0 = local1\Field0
            local0\Field1 = local1\Field1
            showentity(local0\Field2)
            showentity(local0\Field3)
            Exit
        EndIf
    Next
    If (local0\Field4 = Null) Then
        runtimeerrorex(format(format(getlocalstring("runerr", "item"), arg0, "{0}"), (Str arg1), "{1}"))
    EndIf
    resetentity(local0\Field2)
    positionentity(local0\Field2, arg2, arg3, arg4, $01)
    rotateentity(local0\Field2, 0.0, rnd(360.0, 0.0), 0.0, $00)
    local0\Field10 = entitydistancesquared(me\Field60, local0\Field2)
    local0\Field5 = 0.0
    local0\Field17 = local0\Field4\Field7
    Select local0\Field4\Field2
        Case $2B
            local0\Field6 = arg5
            local0\Field7 = arg6
            local0\Field8 = arg7
            local0\Field9 = arg8
            local0\Field12 = 1.0
            local3 = copyentity(misc_i\Field1, $00)
            scaleentity(local3, local0\Field4\Field18, local0\Field4\Field18, local0\Field4\Field18, $01)
            positionentity(local3, entityx(local0\Field2, $01), entityy(local0\Field2, $01), entityz(local0\Field2, $01), $00)
            entityparent(local3, local0\Field3, $01)
            entitycolor(local3, (Float arg5), (Float arg6), (Float arg7))
            If (0.0 > arg8) Then
                entityfx(local3, $01)
            EndIf
            entityalpha(local3, (Abs arg8))
            entityshininess(local3, 1.0)
        Case $2D
            If (arg9 = $00) Then
                arg9 = $0A
                setanimtime(local0\Field3, 17.0, $00)
                local0\Field17 = local0\Field4\Field8
            EndIf
        Case $2E
            If (arg9 = $00) Then
                arg9 = $0A
                setanimtime(local0\Field3, 0.0, $00)
                local0\Field17 = local0\Field4\Field8
            EndIf
    End Select
    local0\Field20 = arg9
    local0\Field22 = $01
    local0\Field24 = $00
    mp_initializeitem(local0, $FFFFFFFF)
    catcherrors((((((((((((((((((((("Uncaught: CreateItem.Items(" + arg0) + ", ") + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)) + ", ") + (Str arg4)) + ", ") + (Str arg5)) + ", ") + (Str arg6)) + ", ") + (Str arg7)) + ", ") + (Str arg8)) + ", ") + (Str arg9)) + ")"))
    Return local0
    Return Null
End Function
