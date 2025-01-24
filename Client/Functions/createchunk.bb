Function createchunk.chunk(arg0%, arg1#, arg2#, arg3#, arg4%)
    Local local0.chunk
    Local local1.chunkpart
    Local local2%
    local0 = (New chunk)
    local0\Field6 = createpivot($00)
    positionentity(local0\Field6, (arg1 + 20.0), arg2, (arg3 + 20.0), $01)
    local0\Field1 = arg1
    local0\Field3 = arg2
    local0\Field2 = arg3
    local0\Field5 = arg4
    If (arg0 > $FFFFFFFF) Then
        local0\Field4 = jsongetarraysize(jsongetarray(jsongetvalue(jsongetarrayvalue(scp1499chunks, arg0), "objects")))
        For local1 = Each chunkpart
            If (local1\Field3 = arg0) Then
                For local2 = $00 To (local0\Field4 - $01) Step $01
                    local0\Field0[local2] = copyentity(local1\Field1[local2], local0\Field6)
                Next
            EndIf
        Next
    EndIf
    local0\Field7 = copyentity(playerroom\Field11[$00], local0\Field6)
    entitytype(local0\Field7, $01, $00)
    entitypickmode(local0\Field7, $02, $01)
    Return local0
    Return Null
End Function
