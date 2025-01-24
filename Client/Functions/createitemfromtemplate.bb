Function createitemfromtemplate.items(arg0%, arg1#, arg2#, arg3#, arg4%, arg5%, arg6%, arg7#, arg8%)
    Local local0%
    Local local1%
    Local local2.items
    Local local3.itemtemplates
    Local local5%
    catcherrors((((((((((((((((((((("CreateItem.Items(" + (Str local0)) + ", ") + (Str local1)) + ", ") + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)) + ", ") + (Str arg4)) + ", ") + (Str arg5)) + ", ") + (Str arg6)) + ", ") + (Str arg7)) + ", ") + (Str arg8)) + ")"))
    local0 = (Int lower((Str local0)))
    local2 = (New items)
    For local3 = Each itemtemplates
        If (local3\Field21 = arg0) Then
            local2\Field4 = local3
            local2\Field2 = createpivot($00)
            entityradius(local2\Field2, 0.01, 0.0)
            entitypickmode(local2\Field2, $01, $00)
            local2\Field3 = copyentity(local3\Field5, local2\Field2)
            local2\Field0 = local3\Field0
            local2\Field1 = local3\Field1
            showentity(local2\Field2)
            showentity(local2\Field3)
            Exit
        EndIf
    Next
    If (local2\Field4 = Null) Then
        runtimeerrorex(format(format(getlocalstring("runerr", "item"), (Str local0), "{0}"), (Str local1), "{1}"))
    EndIf
    resetentity(local2\Field2)
    positionentity(local2\Field2, arg1, arg2, arg3, $01)
    rotateentity(local2\Field2, 0.0, rnd(360.0, 0.0), 0.0, $00)
    local2\Field10 = entitydistancesquared(me\Field60, local2\Field2)
    local2\Field5 = 0.0
    local2\Field17 = local2\Field4\Field7
    Select local2\Field4\Field2
        Case $2B
            local2\Field6 = arg4
            local2\Field7 = arg5
            local2\Field8 = arg6
            local2\Field9 = arg7
            local2\Field12 = 1.0
            local5 = copyentity(misc_i\Field1, $00)
            scaleentity(local5, local2\Field4\Field18, local2\Field4\Field18, local2\Field4\Field18, $01)
            positionentity(local5, entityx(local2\Field2, $01), entityy(local2\Field2, $01), entityz(local2\Field2, $01), $00)
            entityparent(local5, local2\Field3, $01)
            entitycolor(local5, (Float arg4), (Float arg5), (Float arg6))
            If (0.0 > arg7) Then
                entityfx(local5, $01)
            EndIf
            entityalpha(local5, (Abs arg7))
            entityshininess(local5, 1.0)
        Case $2D
            If (arg8 = $00) Then
                arg8 = $0A
                setanimtime(local2\Field3, 17.0, $00)
                local2\Field17 = local2\Field4\Field8
            EndIf
        Case $2E
            If (arg8 = $00) Then
                arg8 = $0A
                setanimtime(local2\Field3, 0.0, $00)
                local2\Field17 = local2\Field4\Field8
            EndIf
    End Select
    local2\Field20 = arg8
    local2\Field22 = $01
    local2\Field24 = $00
    mp_initializeitem(local2, $FFFFFFFF)
    catcherrors((((((((((((((((((((("Uncaught: CreateItem.Items(" + (Str local0)) + ", ") + (Str local1)) + ", ") + (Str arg1)) + ", ") + (Str arg2)) + ", ") + (Str arg3)) + ", ") + (Str arg4)) + ", ") + (Str arg5)) + ", ") + (Str arg6)) + ", ") + (Str arg7)) + ", ") + (Str arg8)) + ")"))
    Return local2
    Return Null
End Function
