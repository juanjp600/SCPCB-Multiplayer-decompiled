Function createitemtemplate.itemtemplates(arg0$, arg1$, arg2$, arg3$, arg4$, arg5#, arg6$, arg7$, arg8%, arg9%, arg10%)
    Local local0.itemtemplates
    Local local1%
    Local local2.itemtemplates
    Local local3%
    local0 = (New itemtemplates)
    For local2 = Each itemtemplates
        If (((local2\Field6 = arg2) And (local2\Field5 <> $00)) <> 0) Then
            local0\Field5 = copyentity(local2\Field5, $00)
            local0\Field7 = local2\Field6
            Exit
        EndIf
    Next
    If (local0\Field5 = $00) Then
        If (arg8 <> $00) Then
            local0\Field5 = loadanimmesh_strict(arg2, $00)
            local0\Field13 = $01
        Else
            local0\Field5 = loadmesh_strict(arg2, $00)
            local0\Field13 = $00
        EndIf
        local0\Field6 = arg2
    EndIf
    local0\Field6 = arg2
    If (arg6 <> "") Then
        local3 = loadtexture_strict(arg6, arg9)
        entitytexture(local0\Field5, local3, $00, $00)
        freetexture(local3)
    EndIf
    local0\Field14 = arg5
    scaleentity(local0\Field5, arg5, arg5, arg5, $01)
    For local2 = Each itemtemplates
        If (((local2\Field10 = arg3) And (local2\Field8 <> $00)) <> 0) Then
            local0\Field8 = local2\Field8
            If (local2\Field9 <> $00) Then
                local0\Field9 = local2\Field9
            EndIf
            Exit
        EndIf
    Next
    If (local0\Field8 = $00) Then
        If (arg10 = $01) Then
            local0\Field8 = create3dicon($40, $40, arg2, arg6, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, $00)
            maskimage(local0\Field8, $7B, $36, $22)
        Else
            local0\Field8 = loadimage_strict(arg3)
            local0\Field10 = arg3
            maskimage(local0\Field8, $7B, $36, $22)
            If (((imagewidth(local0\Field8) > $40) Or (imageheight(local0\Field8) > $40)) <> 0) Then
                resizeimage(local0\Field8, 64.0, 64.0)
            EndIf
        EndIf
    EndIf
    If (arg7 <> "") Then
        If (local0\Field9 = $00) Then
            local0\Field9 = loadimage_strict(arg7)
            maskimage(local0\Field9, $7B, $36, $22)
            If (((imagewidth(local0\Field9) > $40) Or (imageheight(local0\Field9) > $40)) <> 0) Then
                resizeimage(local0\Field9, 64.0, 64.0)
            EndIf
        EndIf
    Else
        local0\Field9 = $00
    EndIf
    local0\Field11 = arg4
    local0\Field2 = arg1
    local0\Field1 = arg0
    local0\Field3 = $01
    local0\Field0 = findfreeitemtemplateid()
    hideentity(local0\Field5)
    If (arg1 = "chicken") Then
        rotatemesh(local0\Field5, 0.0, 0.0, 90.0)
    EndIf
    local0\Field0 = (((((((((((generateseednumber(arg0) + generateseednumber(arg1)) + generateseednumber(arg2)) + generateseednumber(arg3)) + generateseednumber(arg4)) + generateseednumber((Str arg5))) + generateindex(arg0)) + generateindex(arg1)) + generateindex(arg2)) + generateindex(arg3)) + generateindex(arg4)) + generateindex((Str arg5)))
    Return local0
    Return Null
End Function
