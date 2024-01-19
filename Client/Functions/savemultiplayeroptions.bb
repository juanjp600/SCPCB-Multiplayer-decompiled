Function savemultiplayeroptions%()
    Local local0%
    Local local1.servers
    If (filesize("Data\multiplayer.ini") = $00) Then
        createfile("Data\multiplayer.ini")
    EndIf
    local0 = writefile("Data\multiplayer.ini")
    writefloat(local0, (Float deletecharfromstring(multiplayer_version, ".", $03)))
    writeline(local0, nickname)
    writeline(local0, "NULL")
    writeint(local0, networkserver\Field25)
    writeint(local0, networkserver\Field24)
    writeint(local0, $00)
    writebyte(local0, (Int (voice\Field6 * 100.0)))
    writebyte(local0, (Int (mainplayersvolume * 100.0)))
    writebyte(local0, networkserver\Field40)
    writeshort(local0, (Int networkserver\Field41))
    writebyte(local0, voice\Field14)
    For local1 = Each servers
        If (((local1\Field15 = $00) And (local1\Field0 <> $00)) <> 0) Then
            writeint(local0, $01)
            writeint(local0, iptodecimal(local1\Field1))
            writeint(local0, (Int local1\Field2))
            writeint(local0, local1\Field0)
        EndIf
    Next
    writeint(local0, $00)
    writefloat(local0, (Float graphicwidth))
    writefloat(local0, (Float graphicheight))
    writefloat(local0, chatoffsetx)
    writefloat(local0, chatoffsety)
    writefloat(local0, chatwidth)
    writefloat(local0, chatheight)
    writebyte(local0, chattypes)
    closefile(local0)
    Return $00
End Function
