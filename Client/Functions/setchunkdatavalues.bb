Function setchunkdatavalues%()
    Local local0$
    Local local1%
    Local local2%
    local0 = ""
    seedrnd(generateseednumber(randomseed))
    For local1 = $00 To $3F Step $01
        For local2 = $00 To $3F Step $01
            chunkdata(local1, local2) = rand($00, getiniint("Data\1499chunks.INI", "general", "count", $00))
        Next
    Next
    seedrnd(millisecs2())
    Return $00
End Function
