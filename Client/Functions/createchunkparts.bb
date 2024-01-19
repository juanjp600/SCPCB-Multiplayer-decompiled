Function createchunkparts%(arg0.rooms)
    Local local0$
    Local local1%
    Local local2%
    Local local3$
    Local local4%
    Local local5.chunkpart
    Local local6.chunkpart
    Local local7%
    Local local8%
    Local local9%
    Local local10$
    Local local11$
    Local local12$
    local0 = "Data\1499chunks.INI"
    local1 = getiniint(local0, "general", "count", $00)
    local3 = ""
    seedrnd(generateseednumber(randomseed))
    For local2 = $00 To local1 Step $01
        local8 = getinisectionlocation(local0, ("chunk" + (Str local2)))
        If (local8 > $00) Then
            local3 = getinistring2(local0, local8, "count", "")
            local5 = (New chunkpart)
            local5\Field0 = (Int local3)
            debuglog("------------------")
            For local4 = $00 To (Int local3) Step $01
                local9 = (Int getinistring2(local0, local8, ("obj" + (Str local4)), ""))
                local10 = getinistring2(local0, local8, (("obj" + (Str local4)) + "-x"), "")
                local11 = getinistring2(local0, local8, (("obj" + (Str local4)) + "-z"), "")
                local12 = getinistring2(local0, local8, (("obj" + (Str local4)) + "-yaw"), "")
                debuglog(((((("1499 chunk X/Z/Yaw: " + local10) + "|") + local11) + "|") + local12))
                local5\Field1[local4] = copyentity(arg0\Field25[local9], $00)
                If (lower(local12) = "random") Then
                    local5\Field2[local4] = rnd(360.0, 0.0)
                    rotateentity(local5\Field1[local4], 0.0, local5\Field2[local4], 0.0, $00)
                Else
                    rotateentity(local5\Field1[local4], 0.0, (Float local12), 0.0, $00)
                EndIf
                positionentity(local5\Field1[local4], (Float local10), 0.0, (Float local11), $00)
                scaleentity(local5\Field1[local4], roomscale, roomscale, roomscale, $00)
                entitytype(local5\Field1[local4], $01, $00)
                entitypickmode(local5\Field1[local4], $02, $01)
                hideentity(local5\Field1[local4])
            Next
            local6 = (Before local5)
            If (local6 <> Null) Then
                local5\Field3 = (local6\Field3 + $01)
            EndIf
            debuglog("<<<<<<<<<<<<<<<<")
            debuglog((("Generated 1499 chunk " + (Str local5\Field3)) + " sucessfully"))
        EndIf
    Next
    seedrnd(millisecs2())
    Return $00
End Function
