Function setattachmodelvariety%(arg0%, arg1%, arg2$, arg3$)
    Local local0%
    Local local1%
    Local local2.mp_attachmodel
    Local local3%
    If (((((attachmodels[arg0] = Null) Lor (arg0 = $00)) Lor (arg1 >= $04)) Lor (arg2 = "")) <> 0) Then
        Return $00
    EndIf
    If (attachmodels[arg0]\Field3[arg1] <> $00) Then
        freeentity(attachmodels[arg0]\Field3[arg1])
        attachmodels[arg0]\Field3[arg1] = $00
    EndIf
    local0 = $00
    local1 = $00
    arg2 = lower(arg2)
    arg3 = lower(arg3)
    For local2 = Each mp_attachmodel
        For local3 = $00 To $04 Step $01
            If (local2\Field1[local3] = arg2) Then
                local0 = local2\Field3[local3]
            EndIf
            If (local2\Field2[local3] = arg3) Then
                local1 = local2\Field4[local3]
            EndIf
        Next
    Next
    If (local0 = $00) Then
        local0 = loadmesh_strict(arg2, $00)
    EndIf
    If (((local1 = $00) And (arg3 <> "")) <> 0) Then
        local1 = loadtexture_strict(arg3, $01, $01, $01)
    EndIf
    attachmodels[arg0]\Field1[arg1] = arg2
    attachmodels[arg0]\Field3[arg1] = local0
    attachmodels[arg0]\Field2[arg1] = arg3
    attachmodels[arg0]\Field4[arg1] = local1
    Return $01
    Return $00
End Function
