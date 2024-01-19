Function createchunk.chunk(arg0%, arg1#, arg2#, arg3#, arg4%)
    Local local0.chunk
    Local local1%
    Local local2.chunkpart
    local0 = (New chunk)
    local0\Field6 = createpivot($00)
    local0\Field1 = arg1
    local0\Field3 = arg2
    local0\Field2 = arg3
    positionentity(local0\Field6, (local0\Field1 + 20.0), local0\Field3, (local0\Field2 + 20.0), $01)
    local0\Field5 = arg4
    If (arg0 > $FFFFFFFF) Then
        local0\Field4 = getiniint("Data\1499chunks.INI", ("chunk" + (Str arg0)), "count", $00)
        For local2 = Each chunkpart
            If (local2\Field3 = arg0) Then
                For local1 = $00 To local0\Field4 Step $01
                    local0\Field0[local1] = copyentity(local2\Field1[local1], local0\Field6)
                Next
            EndIf
        Next
    EndIf
    local0\Field7 = copyentity(dimension1499\Field1\Field25[$00], local0\Field6)
    entitytype(local0\Field7, $01, $00)
    entitypickmode(local0\Field7, $02, $01)
    Return local0
    Return Null
End Function
