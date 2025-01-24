Function createchunkparts%(arg0.rooms)
    Local local0.chunkpart
    Local local1.chunkpart
    Local local2%
    Local local3$
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8$
    Local local9$
    Local local10$
    local6 = jsongetarraysize(scp1499chunks)
    seedrnd(generateseednumber(randomseed))
    For local2 = $00 To (local6 - $01) Step $01
        local5 = jsongetarray(jsongetvalue(jsongetarrayvalue(scp1499chunks, local2), "objects"))
        local0 = (New chunkpart)
        local0\Field0 = jsongetarraysize(local5)
        For local4 = $00 To (local0\Field0 - $01) Step $01
            local7 = jsongetint(jsongetvalue(jsongetarrayvalue(local5, local4), "id"))
            local8 = (Str jsongetint(jsongetvalue(jsongetarrayvalue(local5, local4), "x")))
            local9 = (Str jsongetint(jsongetvalue(jsongetarrayvalue(local5, local4), "z")))
            local10 = (Str jsongetvalue(jsongetarrayvalue(local5, local4), "yaw"))
            local0\Field1[local4] = copyentity(arg0\Field11[local7], $00)
            If (jsonisnull((Int local10)) <> 0) Then
                local0\Field2[local4] = rnd(360.0, 0.0)
                rotateentity(local0\Field1[local4], 0.0, local0\Field2[local4], 0.0, $00)
            Else
                rotateentity(local0\Field1[local4], 0.0, jsongetfloat((Int local10)), 0.0, $00)
            EndIf
            positionentity(local0\Field1[local4], (Float local8), 0.0, (Float local9), $00)
            scaleentity(local0\Field1[local4], (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
            entitytype(local0\Field1[local4], $01, $00)
            entitypickmode(local0\Field1[local4], $02, $01)
            hideentity(local0\Field1[local4])
        Next
        local1 = (Before local0)
        If (local1 <> Null) Then
            local0\Field3 = (local1\Field3 + $01)
        EndIf
    Next
    seedrnd(millisecs())
    Return $00
End Function
