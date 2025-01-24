Function createitemtemplate.itemtemplates(arg0$, arg1$, arg2%, arg3$, arg4$, arg5$, arg6#, arg7%, arg8$, arg9$, arg10%, arg11%)
    Local local0.itemtemplates
    Local local1.itemtemplates
    Local local2%
    local0 = (New itemtemplates)
    arg3 = ("GFX\Items\" + arg3)
    For local1 = Each itemtemplates
        If (((local1\Field6 = arg3) And (local1\Field5 <> $00)) <> 0) Then
            local0\Field5 = copyentity(local1\Field5, $00)
            Exit
        EndIf
    Next
    If (local0\Field5 = $00) Then
        If (arg10 <> 0) Then
            local0\Field5 = loadanimmesh_strict(arg3, $00)
        Else
            local0\Field5 = loadmesh_strict(arg3, $00)
        EndIf
    EndIf
    local0\Field17 = arg10
    local0\Field6 = arg3
    local2 = $00
    If (arg8 <> "") Then
        If (((arg8 = arg5) And (filetype(("GFX\Items\" + arg8)) = $00)) <> 0) Then
            arg8 = ("GFX\Items\HUD Textures\" + arg8)
        Else
            arg8 = ("GFX\Items\" + arg8)
        EndIf
        For local1 = Each itemtemplates
            If (((local1\Field20 = arg8) And (local1\Field19 <> $00)) <> 0) Then
                local2 = local1\Field19
                Exit
            EndIf
        Next
        If (local2 = $00) Then
            If (left(arg8, $17) = "GFX\Items\HUD Textures\") Then
                local2 = getrescaledtexture(arg8, arg11, $100, $100, $00)
            Else
                local2 = loadtexture_strict(arg8, arg11, $00, $01)
            EndIf
            local0\Field20 = arg8
            entitytexture(local0\Field5, local2, $00, $00)
            local0\Field19 = local2
        EndIf
    EndIf
    local0\Field18 = arg6
    scaleentity(local0\Field5, arg6, arg6, arg6, $01)
    arg4 = ("GFX\Items\Inventory Icons\" + arg4)
    For local1 = Each itemtemplates
        If (local1\Field9 = arg4) Then
            If (local1\Field7 <> $00) Then
                local0\Field7 = local1\Field7
                local0\Field9 = local1\Field9
            EndIf
            If (local1\Field8 <> $00) Then
                local0\Field8 = local1\Field8
            EndIf
            Exit
        EndIf
    Next
    If (local0\Field7 = $00) Then
        local0\Field7 = scaleimageex(loadimage_strict(arg4), menuscale, menuscale, $01)
        local0\Field9 = arg4
    EndIf
    If (arg9 <> "") Then
        If (local0\Field8 = $00) Then
            arg9 = ("GFX\Items\Inventory Icons\" + arg9)
            local0\Field8 = scaleimageex(loadimage_strict(arg9), menuscale, menuscale, $01)
        EndIf
    EndIf
    If (arg5 <> "") Then
        arg5 = ("GFX\Items\HUD Textures\" + arg5)
        local0\Field10 = arg5
    EndIf
    local0\Field2 = arg2
    local0\Field1 = arg1
    local0\Field0 = arg0
    local0\Field3 = arg7
    local0\Field21 = (((((((((((((generateseednumber(arg1) + generateseednumber((Str arg2))) + generateseednumber((Str arg7))) + generateseednumber(arg3)) + generateseednumber(arg4)) + generateseednumber(arg5)) + generateseednumber((Str arg6))) + generateindex(arg1)) + generateindex((Str arg2))) + generateindex(arg3)) + generateindex(arg4)) + generateindex(arg5)) + generateindex((Str arg6))) + generateindex((Str arg7)))
    hideentity(local0\Field5)
    Return local0
    Return Null
End Function
