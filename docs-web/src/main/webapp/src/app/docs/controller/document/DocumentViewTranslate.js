'use strict';

angular.module('docs').controller('DocumentViewTranslate',
  function ($scope, Restangular) {

    var original = ($scope.$parent.document.description || '').trim();

    $scope.translation = '';
    $scope.loading     = false;

    translate(original, true);

    $scope.reload = function () {
      translate(original, /*force*/ true);
    };

    function translate(text, force) {
      if (!text) {                     
        $scope.translation = '(No description)';
        return;
      }
      if (!force && $scope.translation) { return; }

      $scope.loading = true;

      Restangular.one('file').post('translate', { text: text })
        .then(function (data) {       
          if (data && data.trans_result) {
            $scope.translation = data.trans_result
                                  .map(function (item) { return item.dst; })
                                  .join('\n');
          } else {
            $scope.translation = '翻译失败：' +
                                 (data.error_msg || '未知错误');
          }
          $scope.loading = false;
        }, function () {               // 失败
          $scope.translation = '网络异常，翻译失败！';
          $scope.loading     = false;
        });
    }
});
