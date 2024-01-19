Function object_create%(arg0%, arg1#, arg2#, arg3#, arg4#, arg5%, arg6%)
    Local local0%
    Local local1.players
    local0 = object_getid()
    If (local0 = $00) Then
        Return $00
    EndIf
    multiplayer_object[local0] = (New mp_objects)
    If (arg5 <> 0) Then
        multiplayer_object[local0]\Field11 = createcube($00)
        addanimseq(multiplayer_object[local0]\Field11, arg6)
        setanimtime(multiplayer_object[local0]\Field11, 0.0, $00)
    Else
        multiplayer_object[local0]\Field11 = loadanimmesh_strict(multiplayer_models[arg0], $00)
    EndIf
    multiplayer_object[local0]\Field0 = arg0
    multiplayer_object[local0]\Field2 = arg1
    multiplayer_object[local0]\Field3 = arg2
    multiplayer_object[local0]\Field4 = arg3
    multiplayer_object[local0]\Field8 = 1.0
    multiplayer_object[local0]\Field15 = $01
    multiplayer_object[local0]\Field1 = local0
    multiplayer_object[local0]\Field12 = arg4
    For local1 = Each players
        local1\Field52 = (local1\Field52 + $01)
    Next
    positionentity(multiplayer_object[local0]\Field11, arg1, arg2, arg3, $00)
    Return local0
    Return $00
End Function
