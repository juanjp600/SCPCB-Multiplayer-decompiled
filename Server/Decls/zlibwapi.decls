.lib "zlibwapi.dll"

zlibwapi_compressbound%(param0%):"compressBound"
zlibwapi_compress2%(param0*, param1*, param2*, param3%, param4%):"compress2"
zlibwapi_uncompress%(param0*, param1*, param2*, param3%):"uncompress"
zlibwapi_adler32%(param0%, param1*, param2%):"adler32"
zlibwapi_crc32%(param0%, param1*, param2%):"crc32"
zlibwapi_unzopen%(param0$):"unzOpen"
zlibwapi_unzclose%(param0%):"unzClose"
zlibwapi_unzgetglobalinfo%(param0%, param1*):"unzGetGlobalInfo"
zlibwapi_unzgetglobalcomment%(param0%, param1*, param2%):"unzGetGlobalComment"
zlibwapi_unzlocatefile%(param0%, param1$, param2%):"unzLocateFile"
zlibwapi_unzgotofirstfile%(param0%):"unzGoToFirstFile"
zlibwapi_unzgotonextfile%(param0%):"unzGoToNextFile"
zlibwapi_unzgetcurrentfileinfo%(param0%, param1*, param2*, param3%, param4*, param5%, param6*, param7%):"unzGetCurrentFileInfo"
zlibwapi_unzopencurrentfile%(param0%):"unzOpenCurrentFile"
zlibwapi_unzopencurrentfilepassword%(param0%, param1$):"unzOpenCurrentFilePassword"
zlibwapi_unzreadcurrentfile%(param0%, param1*, param2%):"unzReadCurrentFile"
zlibwapi_unzclosecurrentfile%(param0%):"unzCloseCurrentFile"
zlibwapi_zipopen%(param0$, param1%):"zipOpen"
zlibwapi_zipclose%(param0%, param1$):"zipClose"
zlibwapi_zipopennewfileinzip%(param0%, param1$, param2*, param3*, param4%, param5*, param6%, param7$, param8%, param9%):"zipOpenNewFileInZip"
zlibwapi_zipopennewfileinzip3%(param0%, param1$, param2*, param3*, param4%, param5*, param6%, param7$, param8%, param9%, param10%, param11%, param12%, param13%, param14$, param15%):"zipOpenNewFileInZip3"
zlibwapi_zipwritefileinzip%(param0%, param1*, param2%):"zipWriteInFileInZip"
zlibwapi_zipclosefileinzip%(param0%):"zipCloseFileInZip"
