Function setchunkdatavalues%()
    Local local0$
    Local local1%
    Local local2%
    Local local3%
    local3 = jsongetarraysize(scp1499chunks)
    local0 = ""
    seedrnd(generateseednumber(randomseed))
    For local1 = $00 To $3F Step $01
        For local2 = $00 To $3F Step $01
            chunkdata[((local2 Shl $06) + local1)] = rand($00, (local3 - $01))
        Next
    Next
    seedrnd(millisecs())
    Return $00
End Function
